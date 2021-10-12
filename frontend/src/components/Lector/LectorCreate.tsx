import { Button, Container, Grid, TextField} from '@mui/material';

export default function LectorCreate() {

return (
    <Container>
      <h2>New Lector</h2>
        <Grid container direction="column" justifyContent="end" spacing={2}>
            <Grid item>
              <TextField id='outlined-basic' label='NroSocio' type='number' variant='outlined' fullWidth/>
            </Grid>

            <Grid item>
              <Button variant="contained" color="primary" fullWidth onClick={()=>{alert('not implemented')}}>CREATE</Button>
            </Grid>
          </Grid>
    </Container>
)}
