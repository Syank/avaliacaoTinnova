import React from 'react';
import '../assets/styles/RegisterVehicle.css';
import '../assets/styles/VehicleDataCard.css';
import { BooleanInput } from './BooleanInput';
import { DataInput } from './DataInput';
import { SelectInput } from './SelectInput';

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

        this.brands = {
            FORD: "Ford",
            BMW: "BMW",
            FERRARI: "Ferrari",
            CHEVROLET: "Chevrolet",
            FIAT: "Fiat",
            HONDA: "Honda",
            HYUNDAI: "Hyundai"
        };

        this.saveChanges = this.saveChanges.bind(this);
        this.changeDataValue = this.changeDataValue.bind(this);
        this.isInputsValid = this.isInputsValid.bind(this);

    }

    changeDataValue(dataField, value) {
        const currentState = this.state;

        currentState[dataField] = value;

        this.setState(currentState);

    }

    async persistChanges() {
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

    isInputsValid() {
        const inputs = this.state;

        if (!this.brands.includes(inputs["brand"])) {
            alert("A marca específicada é inválida");

            return false;
        }

        debugger;

        if (typeof parseInt(inputs["carYear"]) !== 'number' || inputs["carYear"].length !== 4) {
            alert("O ano digitado é inválido");

            return false;
        }

        return true;
    }

    async saveChanges() {
        const confirmation = window.confirm("Deseja realmente registrar um novo veículo?");

        if (confirmation === true && this.isInputsValid() === true) {
            await this.persistChanges();

        }

    }

    render() {
        return (
            <div className='container'>
                <div className='vehicleDatacontainer'>
                    <div className='vehicleInformationsContainer'>
                        <DataInput text={"Nome:"} value={this.state["vehicleName"]} editable={true} changeData={this.changeDataValue} dataField={"vehicleName"}/>
                        <SelectInput editable={true} text={"Marca:"} options={this.brands} value={this.state["brand"]} changeData={this.changeDataValue} dataField={"brand"}/>
                        <DataInput text={"Ano:"} value={this.state["carYear"]} editable={true} changeData={this.changeDataValue} dataField={"carYear"}/>
                    </div>
                    <div className='vehicleInformationsContainer'>
                        <DataInput text={"Descrição:"} value={this.state["description"]} editable={true} changeData={this.changeDataValue} dataField={"description"}/>
                        <BooleanInput text={"Vendido:"} value={this.state["sold"]} editable={true} changeData={this.changeDataValue} dataField={"sold"}/>
                    </div>
                    <div className='vehicleActions'>
                        <button className='actionButton' onClick={this.saveChanges}>Salvar alterações</button>
                    </div>
                </div>
            </div>
        );
    }
}
