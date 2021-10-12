import * as React from 'react';
import { useHistory } from 'react-router-dom';
import Switcher from './Switcher';
import { styled, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import MuiAppBar, { AppBarProps as MuiAppBarProps } from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';
import { List, ListItem, ListItemText } from '@mui/material';
import ClassIcon from '@mui/icons-material/Class';

const drawerWidth = 240;

const Main = styled('main', { shouldForwardProp: (prop) => prop !== 'open' })<{
  open?: boolean;
}>(({ theme, open }) => ({
  flexGrow: 1,
  padding: theme.spacing(3),
  transition: theme.transitions.create('margin', {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  marginLeft: `-${drawerWidth}px`,
  ...(open && {
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginLeft: 0,
  }),
}));

interface AppBarProps extends MuiAppBarProps {
  open?: boolean;
}

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== 'open',
})<AppBarProps>(({ theme, open }) => ({
  transition: theme.transitions.create(['margin', 'width'], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: `${drawerWidth}px`,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
}));

const DrawerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: 'flex-end',
}));

export default function Menu() {
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);
  const history = useHistory();

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar position="fixed" open={open}>
        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            sx={{ mr: 2, ...(open && { display: 'none' }) }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" noWrap component="div">
Libreria
          </Typography>
        </Toolbar>
      </AppBar>
      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="persistent"
        anchor="left"
        open={open}
      >
        <DrawerHeader>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === 'ltr' ? <ChevronLeftIcon /> : <ChevronRightIcon />}
          </IconButton>
        </DrawerHeader>
        <Divider />
         <List>

         <ListItem button key={'Persona'}  onClick={()=> history.push(`/Persona/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Persona'} />
           </ListItem>
         <ListItem button key={'Autor'}  onClick={()=> history.push(`/Autor/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Autor'} />
           </ListItem>
         <ListItem button key={'Copia'}  onClick={()=> history.push(`/Copia/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Copia'} />
           </ListItem>
         <ListItem button key={'Libro'}  onClick={()=> history.push(`/Libro/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Libro'} />
           </ListItem>
         <ListItem button key={'Lector'}  onClick={()=> history.push(`/Lector/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Lector'} />
           </ListItem>
         <ListItem button key={'Multa'}  onClick={()=> history.push(`/Multa/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Multa'} />
           </ListItem>
         <ListItem button key={'Prestamo'}  onClick={()=> history.push(`/Prestamo/all`)}>
              <ClassIcon color='primary'/> <ListItemText primary={'Prestamo'} />
           </ListItem>        </List>        
      </Drawer>
      <Main open={open}>
        <DrawerHeader />
          <Switcher></Switcher>
      </Main>
    </Box>
  );
}

