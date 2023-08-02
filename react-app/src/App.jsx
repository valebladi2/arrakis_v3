import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar';
import HomePage from './components/HomePage';
import { Bonds } from './components/Bonds';
import { Profile } from './components/Profile';
import { Route, Routes } from 'react-router-dom';

const App = () => {
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
      <Routes>
          <Route path="/home" element={<HomePage/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/bonds" element={<Bonds/>} />
      </Routes>
    </>);
}

export default App;
