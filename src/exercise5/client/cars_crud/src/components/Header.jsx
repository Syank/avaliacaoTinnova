import React from 'react';
import '../assets/styles/Header.css';
import { VehiclesList } from './VehiclesList';
import { VehicleStatistics } from './VehicleStatistics';

export class Header extends React.Component {

    render() {
        return (
            <header className='applicationHeader'>
                <label onClick={() => this.props.setContentToShow(<VehiclesList/>)}>Veículos no sistema</label>
                <label onClick={() => this.props.setContentToShow(<VehicleStatistics/>)}>Estatísticas</label>
            </header>
        );
    }
}
