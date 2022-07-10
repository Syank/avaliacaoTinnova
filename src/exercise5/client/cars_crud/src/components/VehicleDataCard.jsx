import React from 'react';
import '../assets/styles/VehicleDataCard.css';
import { BooleanInput } from './BooleanInput';
import { DataInput } from './DataInput';
import { SelectInput } from './SelectInput';

export class VehicleDataCard extends React.Component {
    constructor(props) {
        super(props);
        
        this.state = {
            ...props
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

        this.delete = this.delete.bind(this);
        this.saveChanges = this.saveChanges.bind(this);
        this.changeDataValue = this.changeDataValue.bind(this);

    }

    changeDataValue(dataField, value) {
        const currentState = this.state;

        currentState[dataField] = value;

        this.setState(currentState);

    }

    async saveChanges() {
        const confirmation = window.confirm("Deseja realmente salvar as alterações?");

        if (confirmation === true) {
            const vehicleId = this.state['id'];

            const response = await fetch("http://localhost:8080/veiculos/" + vehicleId, {
                method: "PATCH",
                body: JSON.stringify(this.state),
                headers: {
                    "Content-Type": "application/json"
                }
            });

            if (response['ok']) {
                alert("As alterações foram salvas com sucesso!");

            } else {
                alert("Ocorreu um problema ao salvar as alterações.");

            }

        }

    }

    async delete() {
        const confirmation = window.confirm("Deseja realmente excluir?");

        if (confirmation === true) {
            const vehicleId = this.state['id'];

            const response = await fetch("http://localhost:8080/veiculos/" + vehicleId, {
                method: "DELETE"
            });

            if (response['ok']) {
                debugger;
                this.props.removeFromList(vehicleId);

                alert("Excluído com sucesso!");

            } else {
                alert("Ocorreu um problema ao excluir o veículo.");

            }

        }

    }

    render() {
        debugger
        return (
            <div className='vehicleDatacontainer'>
                <div className='vehicleInformationsContainer'>
                    <DataInput text={"Nome:"} value={this.props["vehicleName"]} editable={this.props["editable"]} changeData={this.changeDataValue} dataField={"vehicleName"}/>
                    <SelectInput editable={this.props["editable"]} text={"Marca:"} options={this.brands} value={this.state["brand"]} changeData={this.changeDataValue} dataField={"brand"}/>
                    <DataInput text={"Ano:"} value={this.props["carYear"]} editable={this.props["editable"]} changeData={this.changeDataValue} dataField={"carYear"}/>
                </div>
                <div className='vehicleInformationsContainer'>
                    <DataInput text={"Descrição:"} value={this.props["description"]} editable={this.props["editable"]} changeData={this.changeDataValue} dataField={"description"}/>
                    <BooleanInput id={this.state["id"]} text={"Vendido:"} value={this.state["sold"]} editable={this.props['editable']} changeData={this.changeDataValue} dataField={"sold"}/>
                    <DataInput text={"Data de criação:"} editable={false} value={this.props["created"]}/>
                    <DataInput text={"Data de atualização:"} editable={false} value={this.props["updated"]}/>
                </div>
                {this.props['editable'] === true &&
                    <div className='vehicleActions'>
                        <button className='actionButton' onClick={this.saveChanges}>Salvar alterações</button>
                        <button className='actionButton' onClick={this.delete}>Excluír veículo</button>
                    </div>
                }
            </div>
        );
    }
}
