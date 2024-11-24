import { useState } from "react";
import { Container, Form, Button, Card } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/auth/login",
        formData
      );

      const token = response.data.token;
      if (token) {
        localStorage.setItem("authToken", token);
        console.log("Token saved:", token);
        alert("Login successful!");
        navigate("/dashboard");
      } else {
        throw new Error("No token received.");
      }
    } catch (error) {
      console.error("Error logging in:", error.response?.data || error.message);
      setErrorMessage(error.response?.data?.message || "Login failed.");
    }
  };

  return (
    <Container className="d-flex justify-content-center align-items-center vh-100">
      <Card style={{ width: "30rem" }} className="shadow-lg">
        <Card.Body>
          <h2 className="text-center mb-4">Login</h2>
          {errorMessage && (
            <p className="text-danger text-center">{errorMessage}</p>
          )}
          <Form onSubmit={handleSubmit}>
            <Form.Group controlId="formBasicEmail">
              <Form.Control
                type="text"
                placeholder="Enter email"
                name="username"
                value={formData.username}
                onChange={handleChange}
              />
            </Form.Group>

            <Form.Group controlId="formBasicPassword" className="mt-3">
              <Form.Control
                type="password"
                placeholder="Password"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100 mt-2">
              Login
            </Button>
          </Form>
          <div className="text-center mt-3">
            <Link to="/register">Don&#39;t have an account? Register</Link>
          </div>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default Login;
