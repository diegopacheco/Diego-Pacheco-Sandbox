require 'spec_helper'

describe "people/edit.html.erb" do
  before(:each) do
    @person = assign(:person, stub_model(Person,
      :name => "MyText",
      :twitter => "MyText",
      :born => ""
    ))
  end

  it "renders the edit person form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => people_path(@person), :method => "post" do
      assert_select "textarea#person_name", :name => "person[name]"
      assert_select "textarea#person_twitter", :name => "person[twitter]"
      assert_select "input#person_born", :name => "person[born]"
    end
  end
end
