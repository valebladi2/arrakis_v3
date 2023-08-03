import React from 'react'
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";


export const Profile = () => {

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
    <>Profile</>
    </>
  )
}
