import React from 'react';
import PropTypes from 'prop-types';

const Example = ({ title }) => <h1>{ title }</h1>;

Example.propTypes = {
  title: PropTypes.string.isRequired,
};

export default Example;
