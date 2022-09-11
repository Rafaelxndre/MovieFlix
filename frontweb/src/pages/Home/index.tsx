import { ReactComponent as AuthImage } from 'assets/images/auth-image.svg';
import { Switch, Route } from 'react-router-dom';
import './styles.css';

const Auth = () => {
  return (
  <div className="auth-container">
    <div className="auth-banner-container">
            <h1>Avalie Filmes</h1>
            <p>Diga o que você achou do seu filme favorito</p>
            <AuthImage />
    </div>
    <div className="auth-form-container">
        <Switch>
          <Route path="/login">
              <h1>Card de Login</h1>
          </Route>
        </Switch>
    </div>
  </div>
  );
};

export default Auth;
