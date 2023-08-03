import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";

const Homepage = () => {
  return (
      <>
        <Navbar class="navbar navbar-light" style={{backgroundColor: "#e3f2fd"}}>
          <Container>
            <Navbar.Brand href="/home">
              <img src={require('G:\\Coding Challenge\\arrakis_v3\\react-app\\src\\images\\Deutsche-Bank-Logo.png')} width="100px" height="50px" />
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link href="/bonds"><b>Bonds</b></Nav.Link>
                <Nav.Link href="/profile"><b>Profile</b></Nav.Link>
                <Nav.Link href="/logout"><b>Logout</b></Nav.Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
        <div style={{ background: "linear-gradient(to bottom right, #000FFF, #000000)", minHeight: "calc(100vh - 56px)", padding: "20px" }}></div>
        <h1 style={{position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)", padding: "10px", color: "#FFFFFF"}}>Welcome "username" !</h1>
    </>
  );
};

export default Homepage;
