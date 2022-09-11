import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import Home from 'pages/Home';
import Navbar from 'components/Navbar';

const Routes = () => (
  <BrowserRouter>
  <Navbar />
    <Switch>
        <Redirect from="/" to="/login" exact />
      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </BrowserRouter>
);

export default Routes;
