import React from 'react';
import '../assets/styles/Cards.css';

export class DecadeFabricationCard extends React.Component {
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
        
        const decadesList = Object.keys(groups).sort(
            function(a, b) {
                return parseInt(a) - parseInt(b);
            }
        );

        const labels = [];

        for (let i = 0; i < decadesList.length; i++) {
            const decade = decadesList[i];

            const text = groups[decade] === 1 ? "veículo" : "veículos";
            
            const decadeLabel = (
                <label key={"react-list-key-" + i}>Década {decade}: {groups[decade]} {text}</label>
            );

            labels.push(decadeLabel);

        }

        return labels;
    }

    aggregateByDecade() {
        const vehiclesListData = this.state["vehiclesListData"];

        const groups = {};

        for (let i = 0; i < vehiclesListData.length; i++) {
            const vehicleData = vehiclesListData[i];
            
            let year = vehicleData["carYear"].toString();
            
            year = year.substring(0, year.length - 1) + "0";

            if (!groups.hasOwnProperty(year)) {
                groups[year] = 0;
            }

            groups[year]++;

        }

        return groups;
    }


    render() {
        return (
            <aside className='card'>
                <label>Data de fabricação por década</label>
                {this.constructVisualInformation()}
            </aside>
        );
    }
}
