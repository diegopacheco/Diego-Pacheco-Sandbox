component Main {
  state value : String = ""

  get peeled : String {
    if (String.size(value) >= 2) {
      `#{value}.slice(1,-1)`
    } else {
      "Invalid"
    }
  }

  fun setValue (event : Html.Event) : Promise(Never, Void) {
    next { value = Dom.getValue(event.target) }
  }

  fun render : Html {
    <div>
      <input
        value={value}
        onChange={setValue}/>

      <div>
        <{ peeled }>
      </div>
    </div>
  }
}
