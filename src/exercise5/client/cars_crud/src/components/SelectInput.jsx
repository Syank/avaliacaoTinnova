import React from 'react';
import '../assets/styles/SelectInput.css';

export class SelectInput extends React.Component {
    constructor(props){
        super(props);

        this.onValueChanged = this.onValueChanged.bind(this);
        
    }

    onValueChanged(event) {
        const input = event.currentTarget;

        const newValue = input.value;

        this.props.changeData(this.props["dataField"], newValue);

    }

    getOptions() {
        const optionsList = this.props["options"];

        const options = Object.keys(optionsList);

        const optionsElements = [];

        for (let i = 0; i < options.length; i++) {
            const option = options[i];
            const optionValue = optionsList[option];

            const optionElement = (
                <option value={option} key={'react-list-key-' + i}>{optionValue}</option>
            );

            optionsElements.push(optionElement);
        }

        return optionsElements;
    }

    render() {
        debugger
        return (
            <>
                <label>{this.props["text"]}</label>
                {this.props['editable'] === false ?
                    <select onChange={this.onValueChanged} value={this.props["value"]} disabled>
                        {this.getOptions()}
                    </select>
                    :
                    <select onChange={this.onValueChanged} value={this.props["value"]}>
                        {this.getOptions()}
                    </select>
                }
            </>
        );
    }
}
