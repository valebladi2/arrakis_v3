import React, { useEffect } from 'react'
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Image from './../images/Deutsche-Bank-Logo.png'
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import {getAllBondsOfAUser} from "../services/bonds-service";
import {signOut} from "firebase/auth";
import auth from "../config/firebase";

export const Bonds = () => {

    const [date, setDate] = useState('12-July-2021');
    const [type, setType] = useState('Sovereign');
    const [isShown, setIsShown] = useState(false);
    const [bonds, setBonds] = useState([]);

    const handleClick = event => {
        setIsShown(true);
    }

    let navigate = useNavigate();



    const logOut = async () => {
        try {
            const shouldLogout = window.confirm("Are you sure you want to logout?");
            if (shouldLogout){
                await signOut(auth);
                navigate('/login')
            }
            console.log("Logout successfully!")

        } catch (err){
            console.error(err);
        }
    };


    useEffect(() => {
        getAllBondsofAUserAPI();
    }, [])

    const getAllBondsofAUserAPI = () => {
        getAllBondsOfAUser()
            .then(res => {
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
            })

    }


    return (
        < >
            <Navbar class="navbar navbar-light" style={{ backgroundColor: "#e3f2fd" }}>
                <Container>
                    <Navbar.Brand href="/home">
                        <img src={Image} width="100px" height="50px" />
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/bonds"><b>Bonds</b></Nav.Link>
                            <Nav.Link href="/profile"><b>Profile</b></Nav.Link>
                            <Nav.Link onClick={logOut}><b>Logout</b></Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <div style={{ background: "linear-gradient(to bottom right, #000FFF, #000000)", minHeight: "calc(100vh - 56px)", padding: "20px" }}>
                <div>
                    <label style={{color: "#FFFFFF" }}>
                        <b>Choose the bondholder:</b><br></br>
                        <select>
                            <option value="az_holding_inc">AZ Holdings Inc</option>
                            <option value="acme_so">Acme co</option>
                            <option value="sovereign_investments">Sovereign Investments</option>
                            <option value="astra_trading_ltd">Astra Trading Ltd</option>
                            <option value="muncipal_gov_of_orange_county">Muncipal Gov Of Orange County</option>
                            <option value="goldman_sachs">Goldman Sachs</option>
                            <option value="ubs">UBS</option>
                            <option value="barclays">Barclays</option>
                            <option value="british_telecom">British Telecom</option>
                            <option value="pension_holdings">Pension Holdings</option>
                            <option value="zurich_pension_fund_4">Zurich Pension fund 4</option>
                        </select>

                    </label>
                </div>
                <div className="card" style={{ width: "18rem", marginLeft: "600px", marginTop: "100px" }}>
                    <div className="card-body" >
                        <h5 className="card-title">Bond</h5>
                        <button type="submit" className="btn btn-primary" >Previous</button>
                        <button type="submit" className="btn btn-primary" onClick={handleClick} style={{ marginLeft: "10px" }}>Details</button>
                        <button type="submit" className="btn btn-primary" style={{ marginLeft: "20px" }} >Next</button>
                    </div>
                </div>

                {isShown && (<>
                    <h2 style={{ color: "white" }}>More details:</h2>
                    <table className="table" style={{ borderStyle: "solid", borderRadius: "20px", borderColor: "gray" }} >
                        <thead>
                            <tr>
                                <th scope="col">Book name</th>
                                <th scope="col">Bond Holder</th>
                                <th scope="col">Status</th>
                                <th scope="col">Issuer Name</th>
                                <th scope="col">ISIN</th>
                                <th scope="col">CUSIP</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Bond Maturity Date</th>
                                <th scope="col">Bond Currency</th>
                                <th scope="col">Coupon Percent</th>
                                <th scope="col">Unit Price</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{bonds[0].split(",")[0]}</td>
                                <td>{bonds[0].split(",")[1]}</td>
                                <td>{bonds[0].split(",")[2]}</td>
                                <td>{bonds[0].split(",")[3]}</td>
                                <td>{bonds[0].split(",")[4]}</td>
                                <td>{bonds[0].split(",")[5]}</td>
                                <td>{bonds[0].split(",")[6]}</td>
                                <td>{bonds[0].split(",")[7]}</td>
                                <td>{bonds[0].split(",")[8]}</td>
                                <td>{bonds[0].split(",")[9]}</td>
                                <td>{bonds[0].split(",")[10]}</td>
                            </tr>
                            <tr>
                                <td>{bonds[1].split(",")[0]}</td>
                                <td>{bonds[1].split(",")[1]}</td>
                                <td>{bonds[1].split(",")[2]}</td>
                                <td>{bonds[1].split(",")[3]}</td>
                                <td>{bonds[1].split(",")[4]}</td>
                                <td>{bonds[1].split(",")[5]}</td>
                                <td>{bonds[1].split(",")[6]}</td>
                                <td>{bonds[1].split(",")[7]}</td>
                                <td>{bonds[1].split(",")[8]}</td>
                                <td>{bonds[1].split(",")[9]}</td>
                                <td>{bonds[1].split(",")[10]}</td>
                            </tr>
                        </tbody>
                    </table>
                </>


                )}

            </div>


        </>

    )
}

