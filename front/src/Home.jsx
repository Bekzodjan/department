import React, {useEffect, useState} from 'react';
import axios from "axios";
import Rodal from "rodal";
import {useForm} from "react-hook-form";

function Home(props) {
    const [employees, setEmployees] = useState([])
    const [users, setUsers] = useState([])
    const [selectBtn, setSelectBtn] = useState(0)
    const [visible, setVisible] = useState(false)
    const [departments, setDepartments] = useState([])
    const{register,reset,handleSubmit}=useForm()
    useEffect(() => {
        getUsers()
        getDepartments()
    }, []);
    function getDepartments() {
        axios({
            url:"http://localhost:8080/api/department",
            method:"GET",
            headers:{
                "token":localStorage.getItem("authToken")
            }
        }).then(({data})=> {
            setDepartments(data)
        })
    }
    function getUsers() {
        axios({
            url:"http://localhost:8080/api/users",
            method:"GET",
            headers:{
                "token":localStorage.getItem("authToken")
            }
        }).then(({data})=> {
            setUsers(data)
            console.log(data)
        })
    }


    function openModal() {
        setVisible(!visible)
        reset({
            userId:"",
            hasUser:""
        })
    }

    function saveEmployee(data) {
        console.log(data)
        axios({
            url:`http://localhost:8080/api/employees`,
            method:"POST",
            data:data,
            headers:{
                "token":localStorage.getItem("authToken")
            }
        }).then(()=> {
            getEmployeeByDepartmentId(selectBtn)
        })
        reset()
        openModal()

    }

    function getEmployeeByDepartmentId(id) {
        setSelectBtn(id)
        axios({
            url:`http://localhost:8080/api/employees/${id}`,
            method:"GET",
            headers:{
                "token":localStorage.getItem("authToken")
            }
        }).then(({data})=> {
            console.log(data)
            setEmployees(data)
        })
    }

    function changeGoneDate(value,id) {
        console.log(value)
        if (!value){
            axios({
                url:`http://localhost:8080/api/employees/${id}/gone`,
                method:"PUT",
                headers:{
                    "token":localStorage.getItem("authToken")
                }
            }).then(()=>{
                getEmployeeByDepartmentId(selectBtn)
            })
        }
    }

    return (
        <div className={"vw-100 vh-100 border p-3"}>
            <div className={"w-100 h-25 border my-1 "}>
                <button className={"btn btn-primary"} onClick={openModal}>add employee</button> <br/>
                {
                    departments.map(item=><button onClick={()=>getEmployeeByDepartmentId(item.id)} className={selectBtn===item.id?"btn btn-danger":"btn btn-outline-secondary"} key={item.id}>{item.name}</button>)
                }
            </div>
            <div className={"w-100 h-75 border"}>
                <table className={"table table-hover"}>
                    <thead>
                    <tr>
                        <th>ID:</th>
                        <th>FullName:</th>
                        <th>UserName:</th>
                        <th>HasUser:</th>
                        <th>ArrivedDate:</th>
                        <th>GoneDate:</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        employees.map(item=><tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.fullName}</td>
                            <td>{item.userName}</td>
                            <td>
                                <input disabled type="checkbox" defaultChecked={item.hasUser}/>
                            </td>
                            <td>{item.arrivedDate}</td>
                            <td>
                                <input checked={item.goneDate!==null} type="checkbox" onChange={(e)=>changeGoneDate(item.goneDate!==null,item.id)}/><br/>
                                {item.goneDate}
                            </td>
                        </tr>)
                    }
                    </tbody>
                </table>
            </div>
            <Rodal visible={visible} onClose={openModal}>
                <form onSubmit={handleSubmit(saveEmployee)}>
                    <select {...register("userId")} className={"form-select"}>
                        <option value="">Select employee</option>
                        {
                            users.map(item=> <option key={item.id} value={item.id}>
                                {item.firstName} {item.lastName}
                            </option>)
                        }
                    </select>
                    <input {...register("hasUser")} type="checkbox" className={"my-2"}/> <br/>
                    <button className={"btn btn-danger my-2"}>save</button>
                </form>
            </Rodal>
        </div>
    );
}

export default Home;