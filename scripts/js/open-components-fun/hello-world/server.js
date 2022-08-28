export const data = (context, callback) => {
  const { name } = context.params;
  const { staticPath } = context;

  callback(null, {
    name,
    staticPath
  });
};
