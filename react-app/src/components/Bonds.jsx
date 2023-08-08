import React, { useEffect } from 'react'
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Image from './../images/Deutsche-Bank-Logo.png'
import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import { getAllBonds, getAllBondsOfAUser, getBondsForPlusMinus5Days } from "../services/bonds-service";
import { signOut } from "firebase/auth";
import auth from "../config/firebase";

export const Bonds = () => {

    const [isShown, setIsShown] = useState(false);
    const [allShownBonds, setAllShownBonds] = useState(false);
    const [allBondsByMaturity, setAllBondsByMaturity] = useState(false);
    const [bonds, setBonds] = useState([]);
    const [allBonds, setAllBonds] = useState([]);
    const [selectedBondHolder, setSelectedBondHolder] = useState('Acme co');
    const [selectedDate, setSelectedDate] = useState('');
    const [bondDate, setDate] = useState([]);

    const handleClick = event => {
        setIsShown(true);
    }

    const handleClickDate = event => {
        setAllBondsByMaturity(true);
    }

    let navigate = useNavigate();



    const logOut = async () => {
        try {
            const shouldLogout = window.confirm("Are you sure you want to logout?");
            if (shouldLogout) {
                await signOut(auth);
                navigate('/login')
            }
            console.log("Logout successfully!")

        } catch (err) {
            console.error(err);
        }
    };

    useEffect(() => {
        getAllBondsofAUserAPI(selectedBondHolder);
    }, [selectedBondHolder])

    const getAllBondsofAUserAPI = (bondHolder) => {
        getAllBondsOfAUser(bondHolder)
            .then(res => {
                setBonds(res.data);
            })
            .catch(err => {
                setBonds([]);
                console.log(err);
            })

    }

    const showBonds = () => {
        getAllBonds()
            .then(res => {
                setAllBonds(res.data);
            })
            .catch(err => {
                setAllBonds([]);
                console.log(err);
            })
        setAllShownBonds(true);
    }

    const hideBonds = () => {
        setAllShownBonds(false);
    }

    const handleDateChange = (event) => {
        setSelectedDate(event.target.value);
      };

    useEffect(() => {
        getBondsForPlusMinus5DaysAPI(selectedDate);
    }, [selectedDate])

    const getBondsForPlusMinus5DaysAPI = (bondDate) => {
        getBondsForPlusMinus5Days(bondDate)
            .then(res => {
                setDate(res.data);
            })
            .catch(err => {
                setDate([]);
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
                <div className="card" style={{ width: "14rem", margin: "0 auto", marginTop: "50px", marginBottom: "20px", display: "flex", justifyContent: "center", alignItems: "center" }}>                    <div className="card-body" >
                    <h5 className="card-title">Bonds information</h5>
                </div>
                </div>
                <div>
                    <label style={{ color: "#FFFFFF" }}>
                        <button type="submit" className="btn btn-info" onClick={showBonds}>Show all</button>
                        <button type="submit" className="btn btn-danger" onClick={hideBonds}>Hide all</button><br></br><br></br>
                        {allShownBonds && (<>
                            <h2 style={{ color: "white" }}>All bonds:</h2>
                            <table className="table" style={{ borderStyle: "solid", borderRadius: "20px", borderColor: "gray" }} >
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Book name</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Maturity date</th>
                                        <th scope="col">ISIN</th>
                                        <th scope="col">CUSIP</th>
                                        <th scope="col">Issuer name</th>
                                        <th scope="col">Face value</th>
                                        <th scope="col">Currency</th>
                                        <th scope="col">Coupon percent</th>
                                        <th scope="col">Unit price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {allBonds.map((oneBond, index) => {
                                        return (
                                            <tr key={index}>
                                                <td>{oneBond.id}</td>
                                                <td>{oneBond.bookName}</td>
                                                <td>{oneBond.status}</td>
                                                <td>{oneBond.bondmaturitydate}</td>
                                                <td>{oneBond.isin}</td>
                                                <td>{oneBond.cusip}</td>
                                                <td>{oneBond.issuerName}</td>
                                                <td>{oneBond.faceValue}</td>
                                                <td>{oneBond.bondCurrency}</td>
                                                <td>{oneBond.couponPercent}</td>
                                                <td>{oneBond.unitPrice}</td>
                                            </tr>
                                        );
                                    })}
                                </tbody>
                            </table>
                        </>


                        )}

                        <b>Choose the Bond Holder: </b><br></br>

                        <select onChange={(event) => setSelectedBondHolder(event.target.value)}>
                            <option value="Acme co">Acme co</option>
                            <option value="Sovereign Investments">Sovereign Investments</option>
                            <option value="Astra Trading Ltd">Astra Trading Ltd</option>
                            <option value="Muncipal Gov Of Orange County">Muncipal Gov Of Orange County</option>
                            <option value="Goldman Sachs">Goldman Sachs</option>
                            <option value="UBS">UBS</option>
                            <option value="Barclays">Barclays</option>
                            <option value="British Telecom">British Telecom</option>
                            <option value="Pension Holdings">Pension Holdings</option>
                            <option value="Zurich Pension fund 4">Zurich Pension fund 4</option>
                        </select>
                        <button type="submit" className="btn btn-info" onClick={handleClick} style={{ marginLeft: "10px" }}>See details</button><br></br><br></br>
                    </label>
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
                            {bonds.map((bond, index) => {
                                const bondData = bond.split(',');
                                if (bondData[1] === selectedBondHolder) {
                                    return (
                                        <tr key={index}>
                                            <td>{bondData[0]}</td>
                                            <td>{bondData[1]}</td>
                                            <td>{bondData[2]}</td>
                                            <td>{bondData[3]}</td>
                                            <td>{bondData[4]}</td>
                                            <td>{bondData[5]}</td>
                                            <td>{bondData[6]}</td>
                                            <td>{bondData[7]}</td>
                                            <td>{bondData[8]}</td>
                                            <td>{bondData[9]}</td>
                                            <td>{bondData[10]}</td>
                                        </tr>
                                    );

                                }
                                return null;
                            })}
                        </tbody>
                    </table>
                </>

                )}
                <label style={{ color: "#FFFFFF" }}>
                <b>Insert a date to view Bonds due for maturity within the last and next 5 days: </b>
                        <input
                            type="date"
                            id="datePicker"
                            value={selectedDate}
                            onChange={handleDateChange}
                        />
                        <button type="submit" className="btn btn-info" onClick={handleClickDate} style={{ marginLeft: "10px" }}>See bonds</button><br></br><br></br>

                        <p>Selected Date: {selectedDate}</p>
                </label>

                {allBondsByMaturity && (<>
                    <h2 style={{ color: "white" }}>Plus/minus 5 days maturity dates bonds:</h2>
                    <table className="table" style={{ borderStyle: "solid", borderRadius: "20px", borderColor: "gray" }} >
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Book name</th>
                                <th scope="col">Status</th>
                                <th scope="col">Maturity date</th>
                                <th scope="col">Issuer Name</th>
                                <th scope="col">ISIN</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">CUSIP</th>
                                <th scope="col">Bond Currency</th>
                                <th scope="col">Coupon Percent</th>
                                <th scope="col">Unit Price</th>
                                <th scope="col">Position</th>
                            </tr>
                        </thead>
                        <tbody>
                            {bondDate.map((bondDate1, index) => {
                                const bondDateData = bondDate1.split(',');
                                    return (
                                        <tr key={index}>
                                            <td>{bondDateData[0]}</td>
                                            <td>{bondDateData[1]}</td>
                                            <td>{bondDateData[2]}</td>
                                            <td>{bondDateData[3]}</td>
                                            <td>{bondDateData[4]}</td>
                                            <td>{bondDateData[5]}</td>
                                            <td>{bondDateData[6]}</td>
                                            <td>{bondDateData[7]}</td>
                                            <td>{bondDateData[8]}</td>
                                            <td>{bondDateData[9]}</td>
                                            <td>{bondDateData[10]}</td>
                                            <td>{bondDateData[12]}</td>
                                        </tr>
                                    );
                            })}
                        </tbody>
                    </table>
                </>

                )}
            </div>


        </>

    )
}

