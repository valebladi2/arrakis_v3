import React from 'react'
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";


export const Profile = () => {

  const user = {
    firstName: 'John',
    lastName: 'Doe',
    email: 'johndoe@example.com',
  };

  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark" expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/home"><b>Home</b></Navbar.Brand>
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
      <div className="profile-container" style={{
            position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)", padding: "10px"}}>
        <h2 style={{color: "white"}}>User Profile </h2>
        <div className="profile-label">First Name:</div>
        <div className="profile-value">{user.firstName}</div>

        <div className="profile-label">Last Name:</div>
        <div className="profile-value">{user.lastName}</div>

        <div className="profile-label">Email:</div>
        <div className="profile-value">{user.email}</div>
      </div>
    </>
  )
}
