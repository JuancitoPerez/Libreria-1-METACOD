import { Button, Container, Grid, TextField} from '@mui/material';

export default function CopiaCreate() {

return (
    <Container>
      <h2>New Copia</h2>
        <Grid container direction="column" justifyContent="end" spacing={2}>

            <Grid item>
              <Button variant="contained" color="primary" fullWidth onClick={()=>{alert('not implemented')}}>CREATE</Button>
            </Grid>
          </Grid>
    </Container>
)}
