import React from 'react'
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";


export const Bonds = () => {
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
      <div className="card" style={{width: "18rem"}}>
        <div className="card-body">
          <h5 className="card-title">Card title</h5>
          <h6 className="card-subtitle mb-2 text-muted">Card subtitle</h6>
          <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's
            content.</p>
          <a href="#" className="card-link">Card link</a>
          <a href="#" className="card-link">Another link</a>
        </div>
      </div>
      </>

  )
}

