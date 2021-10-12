import { Button, Container, Grid, TextField} from '@mui/material';

export default function LibroCreate() {

return (
    <Container>
      <h2>New Libro</h2>
        <Grid container direction="column" justifyContent="end" spacing={2}>
            <Grid item>
              <TextField id='outlined-basic' label='Titulo' type='string' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='Editorial' type='string' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='FechaPublicación' type='date' variant='outlined' fullWidth/>
            </Grid>
            <Grid item>
              <TextField id='outlined-basic' label='Fecha' type='string' variant='outlined' fullWidth/>
            </Grid>

            <Grid item>
              <Button variant="contained" color="primary" fullWidth onClick={()=>{alert('not implemented')}}>CREATE</Button>
            </Grid>
          </Grid>
    </Container>
)}
