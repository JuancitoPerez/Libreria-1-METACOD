import { Button, Container, Grid, TextField} from '@mui/material';

export default function PersonaCreate() {

return (
    <Container>
      <h2>New Persona</h2>
        <Grid container direction="column" justifyContent="end" spacing={2}>
            <Grid item>
              <TextField id='outlined-basic' label='Nombre' type='string' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='Apellido' type='string' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='FechaNacimiento' type='date' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='Nacionalidad' type='string' variant='outlined' fullWidth/>
            </Grid>

            <Grid item>
              <Button variant="contained" color="primary" fullWidth onClick={()=>{alert('not implemented')}}>CREATE</Button>
            </Grid>
          </Grid>
    </Container>
)}
