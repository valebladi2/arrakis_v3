import React, { useState } from 'react';

const UserFormRedeemableBonds = () => {
  // State to hold the user input values
  const [date, setDate] = useState('');

  // Event handler for handling input changes
  const handleDateChange = (event) => {
    setDate(event.target.value);
  };


  // Event handler for handling form submission
  const handleSubmit = (event) => {
    event.preventDefault();
    // Process the user input data here (e.g., send it to an API, save to a database, etc.)
    console.log('Submitted data:', {date });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Date:</label>
        <input type="text" value={date} onChange={handleDateChange} placeholder='YYYY-MM-DD'/>
      </div>
      {/* <button type="submit">Submit</button> */}
    </form>
  );
};

export default UserFormRedeemableBonds;
