import React from "react";
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
        <form onSubmit={handleSubmit}>
            <br/>
            <label>Number of runs: 
                <input name="numberOfTimes" type="number" defaultValue="100" onChange={handleChange}/>
            </label>
            <br/>
            <br/>

            <label>Switch: 
                <select name="doSwitch" id="switcher" onChange={handleChange}>
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </label>
            <br/>
            <br/>

            <input type="submit" value="Run Monty Hall simulation"/> 
        </form>
        <br/>
        {state.result && 
            <label>Result: {state.result}</label>
        }
        
        </>
    );


};

export default MontyGame;