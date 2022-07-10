import React from 'react';
import '../assets/styles/RegisterVehicle.css';
import '../assets/styles/VehicleDataCard.css';
import { DataInput } from './DataInput';

export class RegisterVehicle extends React.Component {
    constructor(props) {
        super(props);
    
        this.state = {
            vehicleName: "",
            brand: "",
            carYear: "",
            description: "",
            sold: ""
        }

        this.saveChanges = this.saveChanges.bind(this);
        this.changeDataValue = this.changeDataValue.bind(this);

    }

    changeDataValue(dataField, value) {
        const currentState = this.state;

        currentState[dataField] = value;

        this.setState(currentState);

    }

    async saveChanges() {
        const confirmation = window.confirm("Deseja realmente registrar um novo veículo?");

        if (confirmation === true) {
            const response = await fetch("http://localhost:8080/veiculos", {
                method: "POST",
                body: JSON.stringify(this.state),
                headers: {
                    "Content-Type": "application/json"
                }
            });

            if (response['ok']) {
                alert("O novo veículo foi inserido no banco de dados!");

            } else {
                alert("Ocorreu um problema ao cadastrar o novo veículo.");

            }

        }

    }

    render() {
        return (
            <div className='container'>
                <div className='vehicleDatacontainer'>
                    <div className='vehicleInformationsContainer'>
                        <DataInput text={"Nome:"} value={this.state["vehicleName"]} editable={true} changeData={this.changeDataValue} dataField={"vehicleName"}/>
                        <DataInput text={"Marca:"} value={this.state["brand"]} editable={true} changeData={this.changeDataValue} dataField={"brand"}/>
                        <DataInput text={"Ano:"} value={this.state["carYear"]} editable={true} changeData={this.changeDataValue} dataField={"carYear"}/>
                    </div>
                    <div className='vehicleInformationsContainer'>
                        <DataInput text={"Descrição:"} value={this.state["description"]} editable={true} changeData={this.changeDataValue} dataField={"description"}/>
                        <DataInput text={"Vendido:"} value={this.state["sold"]} editable={true} changeData={this.changeDataValue} dataField={"sold"}/>
                    </div>
                    <div className='vehicleActions'>
                        <button className='actionButton' onClick={this.saveChanges}>Salvar alterações</button>
                    </div>
                </div>
            </div>
        );
    }
}
