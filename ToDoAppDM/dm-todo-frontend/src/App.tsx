
import {  useContext} from 'react';
import {UserContext} from './Context/UserContext'
import './App.css';
import Footer from './Components/Basic/Footer';
import StartingPage from './Components/StartingPage/StartingPage';
import ProperApp from './Components/ProperApp/ProperApp';




function App() {

  const userContext = useContext(UserContext);
  if (!userContext) {
  return <div>Błąd: brak UserProvider w drzewie komponentów</div>;
  }
  const { user } = userContext;

  return (
    <>
    <div className="flex flex-col min-h-screen bg-[var(--c3)]">
      <main className='flex-grow'>
        {user==-1 &&<StartingPage></StartingPage>}
        {user!= -1 && <ProperApp></ProperApp> }
        
        </main>
        <Footer></Footer>
    </div>
  
    </>
  );
}

export default App;
