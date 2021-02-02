import axios from "axios";

export default function getSimulation(numberOfTimes, doSwitch) {
    return axios.get(`/monty/${numberOfTimes}/${doSwitch}`)
        .then(res => {
            if(res.status === 200) {
                console.log(`SimulationResult: ${res.data}`)
                return res.data
            } else {
                return "Something went wrong. No result"
            }
        })
}
