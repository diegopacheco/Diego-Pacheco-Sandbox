import { TodoAppAngular8Page } from './app.po';

describe('todo-app-angular8 App', function() {
  let page: TodoAppAngular8Page;

  beforeEach(() => {
    page = new TodoAppAngular8Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
