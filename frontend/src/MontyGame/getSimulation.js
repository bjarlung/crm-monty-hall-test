import axios from "axios";

export default function getSimulation(numberOfTimes, doSwitch) {
    return axios.get(`/monty/${numberOfTimes}/${doSwitch}`)
        .then(res => {
            return res.data
        }).catch(error => {
            console.error(error)
            return "Something went wrong. No result"
        }
        )
}
