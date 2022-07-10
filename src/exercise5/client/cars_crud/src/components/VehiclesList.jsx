import React from 'react';
import '../assets/styles/VehiclesList.css';

export class VehiclesList extends React.Component {

    render() {
        return (
            <div className='listContainer'>
                <div className='vehicleDatacontainer'>
                    <div className='vehicleInformationsContainer'>
                        <label>Nome: Celta</label>
                        <label>Marca: Ford</label>
                        <label>Ano: 2020</label>
                    </div>
                    <div className='vehicleInformationsContainer'>
                        <label>Descrição: as das daksldjksa askjd asjk lads</label>
                        <label>Vendido: Sim</label>
                        <label>Data de criação: 16/09/1997</label>
                        <label>Data de atualização: 16/09/1996</label>
                    </div>
                    <div className='vehicleActions'>
                        <button className='actionButton'>Salvar alterações</button>
                        <button className='actionButton'>Excluír veículo</button>
                    </div>
                </div>
            </div>
        );
    }
}
