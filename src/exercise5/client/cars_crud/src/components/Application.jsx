import React from 'react';
import '../assets/styles/App.css';
import { Header } from './Header';



export class Application extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            currentContent: (<main></main>)
        }

        this.setContentToShow = this.setContentToShow.bind(this);
    }

    setContentToShow(contentToShow) {
        this.setState({currentContent: contentToShow});

    }

    render() {
        return (
            <div className='application'>
                <Header setContentToShow={this.setContentToShow}/>
                {this.state['currentContent']}
            </div>
        );
    }
}
