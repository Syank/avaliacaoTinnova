import React from 'react';
import '../assets/styles/VehiclesList.css';
import { VehicleDataCard } from './VehicleDataCard';

export class VehiclesList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            vehiclesListData: []
        }

        this.removeFromList = this.removeFromList.bind(this);
        this.buildVehiclesList = this.buildVehiclesList.bind(this);

    }

    async componentDidMount() {
        const response = await fetch("http://localhost:8080/veiculos");

        if (response['ok']) {
            const vehiclesListData = await response.json();

            this.setState({vehiclesListData: vehiclesListData})
        }

    }

    removeFromList(id) {
        const vehiclesListData = this.state['vehiclesListData'];

        for (let i = vehiclesListData.length - 1; i >= 0; i--) {
            const vehicleData = vehiclesListData[i];
            
            if (vehicleData["id"] === id) {
                vehiclesListData.splice(i, 1);

            }

        }

        this.setState({vehiclesListData: vehiclesListData});
    }

    buildVehiclesList() {
        const vehiclesListData = this.state['vehiclesListData'];

        const vehicleCards = [];

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            const component = (
                <VehicleDataCard key={"react-list-key-" + i} editable={true} removeFromList={this.removeFromList} {...vehicleData}/>
            );

            vehicleCards.push(component);
        }

        return vehicleCards;
    }

    render() {
        return (
            <div className='listContainer'>
                {this.buildVehiclesList()}
            </div>
        );
    }
}
