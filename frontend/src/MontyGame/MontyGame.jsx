import React from "react";
import './MontyGame.css'
import getSimulation from "./getSimulation";

function MontyGame() {

    const [state, updateState] = React.useState(
        {formData: {
            numberOfTimes: 100, 
            doSwitch: true}
        },
        {result: null
        });

    const handleChange = (e) => {
        updateState({...state, formData: {...state.formData, [e.target.name]: e.target.value}, result: null})
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(state)
        getSimulation(state.formData.numberOfTimes, state.formData.doSwitch)
            .then(res => {
                updateState({...state, result: res});
            })
    };
    
    return (
        <>
        <form onSubmit={handleSubmit} className="monty-form">
            <div>
                <label className="monty-label">Number of runs: 
                    <input className="user-input" name="numberOfTimes" type="number" defaultValue="100" max="99999" min="1" onChange={handleChange}/>
                </label>

                <label className="monty-label">Switch: 
                    <select  className="user-input" name="doSwitch" id="switcher" onChange={handleChange}>
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </label>
            </div>
            <button className="simulation-button" type="submit">Run simulation</button>
        </form>
        {state.result && 
            <label className="result">Number of wins: {state.result}</label>
        } 
        </>
    );


};

export default MontyGame;