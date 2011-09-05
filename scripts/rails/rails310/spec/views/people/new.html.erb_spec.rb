require 'spec_helper'

describe "people/new.html.erb" do
  before(:each) do
    assign(:person, stub_model(Person,
      :name => "MyText",
      :twitter => "MyText",
      :born => ""
    ).as_new_record)
  end

  it "renders new person form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => people_path, :method => "post" do
      assert_select "textarea#person_name", :name => "person[name]"
      assert_select "textarea#person_twitter", :name => "person[twitter]"
      assert_select "input#person_born", :name => "person[born]"
    end
  end
end
