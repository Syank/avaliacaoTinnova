import React from 'react';
import '../assets/styles/VehicleStatistics.css';
import { DecadeFabricationCard } from './DecadeFabricationCard';
import { NotSoldCard } from './NotSoldCard';
import { VehiclesByBrandCard } from './VehiclesByBrandCard';

export class VehicleStatistics extends React.Component {

    render() {
        return (
            <div className='statisticsContainer'>
                <NotSoldCard/>
                <DecadeFabricationCard/>
                <VehiclesByBrandCard/>
            </div>
        );
    }
}
