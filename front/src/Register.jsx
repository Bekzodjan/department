import { useState } from "react";
import { Container, Form, Button, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import axios from "axios";

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    username: "",
    password: "",
    roleType: "",
  });

  const [errorMessage, setErrorMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    console.log(formData);

    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/auth/register",
        formData
      );
      console.log("User registered:", response.data);
      setErrorMessage("");
      alert("Registration successful!");
    } catch (error) {
      console.error(
        "Error registering user:",
        error.response?.data || error.message
      );
      setErrorMessage(error.response?.data?.message || "Registration failed.");
    }
  };

  return (
    <Container className="d-flex justify-content-center align-items-center vh-100">
      <Card style={{ width: "30rem" }} className="shadow-lg">
        <Card.Body>
          <h2 className="text-center mb-4">Register</h2>
          {errorMessage && (
            <p className="text-danger text-center">{errorMessage}</p>
          )}
          <Form onSubmit={handleSubmit}>
            <div className="d-flex gap-4">
              <Form.Group controlId="formBasicUser">
                <Form.Control
                  type="text"
                  placeholder="Enter first name"
                  name="firstName"
                  value={formData.firstName}
                  onChange={handleChange}
                />
              </Form.Group>

              <Form.Group controlId="formBasicUser">
                <Form.Control
                  type="text"
                  placeholder="Enter last name"
                  name="lastName"
                  value={formData.lastName}
                  onChange={handleChange}
                />
              </Form.Group>
            </div>

            <Form.Group controlId="formBasicEmail" className="my-3">
              <Form.Control
                type="text"
                placeholder="Enter username"
                name="username"
                value={formData.username}
                onChange={handleChange}
              />
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
              <Form.Control
                type="password"
                placeholder="Password"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
            </Form.Group>

            <Form.Group controlId="formBasicPassword" className="mt-3">
              <Form.Select
                aria-label="Default select example"
                name="roleType"
                value={formData.roleType}
                onChange={handleChange}
              >
                <option value="ROLE_MANAGER">Manager</option>
                <option value="ROLE_EMPLOYEE">Employee</option>
              </Form.Select>
            </Form.Group>

            <Button variant="primary" type="submit" className="w-100 mt-3">
              Register
            </Button>
          </Form>
          <div className="text-center mt-3">
            <Link to="/login">Already have an account? Login</Link>
          </div>
        </Card.Body>
      </Card>
    </Container>
  );
};

export default Register;
