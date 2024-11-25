import {Routes, Route, useLocation, useNavigate} from "react-router-dom";
import Login from "./Login.jsx";
import Register from "./Register.jsx";
import "rodal/lib/rodal.css"
import "bootstrap/dist/css/bootstrap.css"
import Home from "./Home.jsx";
import {useEffect} from "react";
import axios from "axios";
const App = () => {

    const {pathname} = useLocation();
    const navigate = useNavigate();

    useEffect(() => {
        handleCheckPermission();
    }, [pathname]);

    const permissions = [{path: "/home", roles: ["ROLE_MANAGER"]}]

    const handleCheckPermission = () => {

        if (!pathname.startsWith("/login") && !pathname.startsWith("/register")) {
            if (hasAnyRoles() !== undefined) {
                axios({
                    url: "http://localhost:8080/api/auth/me",
                    method: "GET",
                    headers: {token: localStorage.getItem("authToken")},
                }).then((res) => {
                    console.log(res.data);
                    for (let i = 0; i < res.data.length; i++) {
                        if (hasAnyRoles().includes(res.data[i].name)){
                            return;
                        }
                    }
                    navigate("/login");
                }).catch(() => {
                    navigate("/login");
                    localStorage.removeItem("authToken");
                })
            }else {
                navigate("/login");
            }
        }
    }

    const hasAnyRoles = () => {
        for (let i = 0; i < permissions.length; i++) {
            if (pathname.startsWith(permissions[i].path)) {
                return permissions[i].roles;
            }
        }
    }
    return (
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/home" element={<Home />} />
            </Routes>
    );
};

export default App;
