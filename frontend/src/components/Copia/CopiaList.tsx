import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import CopiaGetAllResponseDto from '../../dtos/Copia/getAll/CopiaGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function CopiaList() {
    const [CopiaList, setCopiaList] = useState<CopiaGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Copia/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Copia List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Copia
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
<TableCell>Estado</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
{CopiaList.length > 0 ? CopiaList.map((row) => (
            <TableRow
              key={row.CopiaId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
                <TableCell component='th' scope='row'>
                       {row.Estado}
                </TableCell>
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
