import React from 'react';
import '../assets/styles/DataInput.css';

export class BooleanInput extends React.Component {
    constructor(props){
        super(props);

        this.onValueChanged = this.onValueChanged.bind(this);
        
    }

    onValueChanged(event) {
        debugger;
        const input = event.currentTarget;

        const newValue = JSON.parse(input.value);

        this.props.changeData(this.props["dataField"], newValue);

    }

    render() {
        return (
            <div className='dataInput'>
                <label>{this.props['text']}</label>
                {this.props['editable'] === false ?
                    <>
                        <label>Sim</label>
                        <input type={"radio"} name={"booleanInput-" + this.props['id']} value={true} checked={this.props["value"]} disabled/>
                        <label>Não</label>
                        <input type={"radio"} name={"booleanInput-" + this.props['id']} value={false} checked={!this.props["value"]} disabled/>
                    
                    </>
                    :
                    <>
                        <label>Sim</label>
                        <input type={"radio"} name={"booleanInput-" + this.props['id']} value={true} checked={this.props["value"]} onChange={this.onValueChanged}/>
                        <label>Não</label>
                        <input type={"radio"} name={"booleanInput-" + this.props['id']} value={false} checked={!this.props["value"]} onChange={this.onValueChanged}/>
                    </>
                }
            </div>
        );
    }
}
