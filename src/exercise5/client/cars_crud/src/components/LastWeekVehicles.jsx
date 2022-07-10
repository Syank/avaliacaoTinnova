import React from 'react';
import '../assets/styles/VehiclesList.css';
import { VehicleDataCard } from './VehicleDataCard';

export class LastWeekVehicles extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            vehiclesListData: []
        }

        this.buildVehiclesList = this.buildVehiclesList.bind(this);
        this.filterVehiclesByLastWeek = this.filterVehiclesByLastWeek.bind(this);

    }

    async componentDidMount() {
        const response = await fetch("http://localhost:8080/veiculos");

        if (response['ok']) {
            const vehiclesListData = await response.json();

            this.setState({vehiclesListData: vehiclesListData})
        }

    }

    buildVehiclesList() {
        const vehiclesListData = this.filterVehiclesByLastWeek();

        const vehicleCards = [];

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            const component = (
                <VehicleDataCard key={"react-list-key-" + i} editable={false} {...vehicleData}/>
            );

            vehicleCards.push(component);
        }

        return vehicleCards;
    }
    
    filterVehiclesByLastWeek() {
        const vehiclesListData = this.state['vehiclesListData'];

        const now = new Date();

        const lastWeek = new Date(now.getFullYear(), now.getMonth(), now.getDate() - 7);

        const lastWeekVehiclesList = [];

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            const vehicleCreation = new Date(vehicleData["created"]);

            if (vehicleCreation > lastWeek) {
                lastWeekVehiclesList.push(vehicleData);

            }

        }

        return lastWeekVehiclesList;
    }

    render() {
        return (
            <div className='listContainer'>
                {this.buildVehiclesList()}
            </div>
        );
    }
}
