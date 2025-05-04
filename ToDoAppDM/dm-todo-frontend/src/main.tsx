import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import './index.css';
import App from './App.tsx';
import { UserProvider } from './Context/UserContext.tsx';


//copied colors from app.css
const theme = createTheme({
  palette: {
    primary: {
      main: '#BF755A', 
    },
    secondary: {
      main: '#BF8450', 
    },
    
    background: {
      default: '#D7D9CC', 
      paper: '#ffffff',    
    },
    text: {
      primary: '#D7D9CC', 
      secondary: '#400101', 
    },
  },
  typography: {
    fontFamily: 'Roboto, Arial, sans-serif',
    h3: {
      fontWeight: 700,
    },
  },
});

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <ThemeProvider theme={theme}>
      <UserProvider>
         <App />
      </UserProvider>
      
    </ThemeProvider>
  </StrictMode>
);
