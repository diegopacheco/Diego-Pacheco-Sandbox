class CreatePeople < ActiveRecord::Migration
  def change
    create_table :people do |t|
      t.text :name
      t.text :twitter
      t.integer :born

      t.timestamps
    end
  end
end
