import auth from "../config/firebase";
import {createUserWithEmailAndPassword, signOut } from "firebase/auth";
import {useState} from "react";

export const Auth = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    console.log(auth?.currentUser?.email);
    console.log(auth?.currentUser?.photoURL);
    const signIn = async () => {
        try {
            await createUserWithEmailAndPassword(auth, email, password);
        } catch (err){
            console.error(err);
        }
    };
    const logOut = async () => {
        try {
            await signOut(auth);
        } catch (err){
            console.error(err);
        }
    };
    return (
        <div>
            <input placeholder="Email.." onChange={(e) => setEmail(e.target.value)} />
            <input
                type="password"
                placeholder="Password.."
                onChange={(e) => setPassword(e.target.value)}
            />
            <button onClick={signIn}> Sign-in</button>
            <button onClick={logOut}> log-out</button>
        </div>
    );
};