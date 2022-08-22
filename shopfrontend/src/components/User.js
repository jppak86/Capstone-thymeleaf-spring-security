import React, { useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

export default function User() {

  const paperStyle={padding: '50px 20px', width:600, margin:"20px auto"}
  const[firstName, setFirstName]= useState('')
  const[lastName, setLastName]= useState('')
  const[email, setEmail]= useState('')
  const[password, setPassword] = useState('')

  const handleClick=(e)=> {
    e.preventDefault()
    const newUser={firstName, lastName, email, password}
    console.log(newUser)
    
    fetch("http://localhost:8686/api/users", {
      
      method:"POST",
      headers:{"Contenty-Type":"text/plain"},
      body:JSON.stringify(newUser)
    }).then(()=>{
      console.log("New User added")

    })

  }

  return (

    <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Add User</h1>
          <Box
            component="form"
            sx={{
              '& > :not(style)': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
          >
            <TextField id="outlined-basic" label="First Name" variant="outlined" fullWidth
            value={firstName}
            onChange={(e)=> setFirstName(e.target.value)}
            />
            <TextField id="outlined-basic" label="Last Name" variant="outlined" fullWidth
            value={lastName}
            onChange={(e)=> setLastName(e.target.value)}
            />
             <TextField id="outlined-basic" label="Email" variant="outlined" fullWidth
             value={email}
             onChange={(e)=> setEmail(e.target.value)}
             />
             <TextField id="outlined-basic" label="Password" variant="outlined" fullWidth
             value={password}
             onChange={(e)=> setPassword(e.target.value)}
             />
            <Button variant="contained" color="secondary"
            onClick={handleClick}
            
            >Submit</Button>
          </Box>
      </Paper>
    </Container>
  );
}
