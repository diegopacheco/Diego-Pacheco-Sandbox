import { mountComponent, loadById, load } from 'nova-react';

import Example from './components/Example';

const render = (name, { node, data }) => {
  if (name === 'Example') {
    return mountComponent(Example, node, data)
  }
}

document.addEventListener('NovaMount', ({ detail }) => {
  const { name, id } = detail

  const payload = loadById(name, id)

  if (payload) {
    render(name, payload)
  }
})

load('Example').forEach(render.bind(null, 'Example'))
