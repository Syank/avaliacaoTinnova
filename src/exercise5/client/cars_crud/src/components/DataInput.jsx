import React from 'react';
import '../assets/styles/DataInput.css';

export class DataInput extends React.Component {
    constructor(props){
        super(props);

        this.onValueChanged = this.onValueChanged.bind(this);
        
    }

    onValueChanged(event) {
        debugger;
        const input = event.currentTarget;

        const newValue = input.value;

        this.props.changeData(this.props["dataField"], newValue);

    }

    render() {
        return (
            <div className='dataInput'>
                <label>{this.props['text']}</label>
                {this.props['editable'] === false ?
                    <input defaultValue={this.props['value']} disabled/>
                    :
                    <input defaultValue={this.props['value']} onChange={this.onValueChanged}/>
                }
            </div>
        );
    }
}
