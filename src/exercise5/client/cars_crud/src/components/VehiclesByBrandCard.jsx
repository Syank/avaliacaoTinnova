import React from 'react';
import '../assets/styles/Cards.css';

export class VehiclesByBrandCard extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            vehiclesListData: []
        }
        
        this.aggregateByDecade = this.aggregateByDecade.bind(this);
        this.constructVisualInformation = this.constructVisualInformation.bind(this);
    }

    async componentDidMount() {
        const response = await fetch("http://localhost:8080/veiculos");

        if (response['ok']) {
            const vehiclesListData = await response.json();

            this.setState({vehiclesListData: vehiclesListData})
        }
    }

    constructVisualInformation() {
        const groups = this.aggregateByDecade();
        
        const brandsList = Object.keys(groups).sort();

        const labels = [];

        for (let i = 0; i < brandsList.length; i++) {
            const brand = brandsList[i];

            const text = groups[brand] === 1 ? "veículo" : "veículos";
            
            const brandLabel = (
                <label key={"react-list-key-" + i}>{brand}: {groups[brand]} {text}</label>
            );

            labels.push(brandLabel);

        }

        return labels;
    }

    aggregateByDecade() {
        const vehiclesListData = this.state["vehiclesListData"];

        const groups = {};

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            const brand = vehicleData["brand"];
            
            if (!groups.hasOwnProperty(brand)) {
                groups[brand] = 0;
            }

            groups[brand]++;

        }

        return groups;
    }


    render() {
        return (
            <aside className='card'>
                <label>Quantia de veículos por fábricante</label>
                {this.constructVisualInformation()}
            </aside>
        );
    }
}
