import React from 'react';
import '../assets/styles/Header.css';
import { LastWeekVehicles } from './LastWeekVehicles';
import { RegisterVehicle } from './RegisterVehicle';
import { VehiclesList } from './VehiclesList';
import { VehicleStatistics } from './VehicleStatistics';

export class Header extends React.Component {

    render() {
        return (
            <header className='applicationHeader'>
                <label onClick={() => this.props.setContentToShow(<LastWeekVehicles/>)}>Última semana</label>
                <label onClick={() => this.props.setContentToShow(<VehiclesList/>)}>Veículos no sistema</label>
                <label onClick={() => this.props.setContentToShow(<VehicleStatistics/>)}>Estatísticas</label>
                <label onClick={() => this.props.setContentToShow(<RegisterVehicle/>)}>Registrar veículo</label>
            </header>
        );
    }
}
