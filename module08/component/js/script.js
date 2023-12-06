window.addEventListener('DOMContentLoaded', function () {
  main()
})

function main() {
  const root = document.getElementById('root')
  let appComponent = new App()
  draw(root, appComponent)
}
function draw(container, component) {
  let fRender = component.render()
  fRender(container)
}
class Component {
  props = {}
  state = {}

  constructor(props) {
    this.props = props
  }

}

class App extends Component {
  constructor(props) {
    super(props)
    this.state = {}

    this.handleChange = this.handleChange.bind(this)
    this.handleChange2 = this.handleChange2.bind(this)
  }

  handleChange(event) {
    console.log(this.state)
    this.state = {
      ...this.state,
      value: event.target.value
    }
    console.log(this.state)
  }

  handleChange2(event) {
    console.log(this.state)
    this.state = {
      ...this.state,
      value2: event.target.value
    }
    console.log(this.state)
  }

  render() {
    return (parent) => {
      let div = document.createElement('div')
      div.textContent = "Hello, I am App component"
      let textField = new TextField({label: "Text Input 1", className: "text-label", onChange: this.handleChange})
      let fRender = textField.render()
      fRender(div)

      let textField2 = new TextField({label: "Text Input 2", className: "text-label", onChange: this.handleChange2})
      let fRender2 = textField2.render()
      fRender2(div)

      let button = document.createElement('button')
      button.onclick = () => console.log(this.state);
      div.append(button)

      // let str = {
      //   one: "one",
      //   two: "two"
      // }
      //
      // let str2 = {
      //   ...str,
      //   three: "three"
      // }

      parent.append(div)
    }
  }
}

class TextField extends Component {

  constructor(props) {
    super(props)
    this.state = {}
  }

  render() {
    return (parent) => {
      let div = document.createElement('div')
      let label = document.createElement('label')
      label.className = this.props.className
      label.append(document.createTextNode(this.props.label))
      let input = document.createElement('input')
      input.onchange = this.props.onChange
      label.append(input)
      div.append(label)
      parent.append(div)
    }
  }
}

