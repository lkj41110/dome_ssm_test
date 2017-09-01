import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import NotFound from 'components/common/NotFound';
import Test from 'components/Test';
import Test2 from 'components/Test2';


const Routes = () =>
  <Router history={hashHistory}>
    <Route path="/" component={Test} />
    <Route path="/test2" component={Test2} />
    <Route path="*" component={NotFound}/>
  </Router>;

Routes.propTypes = {
  history: React.PropTypes.any,
};

export default Routes;
