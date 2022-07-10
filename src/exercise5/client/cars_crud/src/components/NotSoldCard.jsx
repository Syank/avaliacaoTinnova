import React from 'react';
import '../assets/styles/Cards.css';

export class NotSoldCard extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            vehiclesListData: []
        }
        
    }

    async componentDidMount() {
        const response = await fetch("http://localhost:8080/veiculos");

        if (response['ok']) {
            const vehiclesListData = await response.json();

            this.setState({vehiclesListData: vehiclesListData})
        }
    }

    calculateNotSoldVehicles() {
        const vehiclesListData = this.state["vehiclesListData"];

        let notSoldAmount = 0;

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            if (vehicleData["sold"] === false) {
                notSoldAmount++;
            }

        }

        return notSoldAmount;
    }

    render() {
        return (
            <aside className='card'>
                <label>Quantia de veículos não vendidos</label>
                <label>{this.calculateNotSoldVehicles()}</label>
            </aside>
        );
    }
}
